package chap1;

import java.util.*;

public class Chap1 {
    public static void main(String[] args) {
//        System.out.println(new PhoneNumber("010-1234-5678"));
//        System.out.println(new PhoneNumber("010 1234 5678"));
//        System.out.println(new PhoneNumber("01012345678"));
        Person person = new Person("손현석");
        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
        person.addPhoneNumber(new PhoneNumber("01012345678"));
        System.out.println(person);
        System.out.println("-----");

        // 아래 결과값은 false가 출력된다. why?
        // -> contains() 메서드는 equals() 메서드를 사용하여 객체를 비교한다.
        // -> equals()는 오버라이딩이 없으면 객체가 같을 때만 true를 반환한다.
        // -> 이때, 현재 코드에서는 서로 다른 두 객체를 이용하여 진행했으므로 false가 반환된다.
        System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));
        System.out.println("-----");

        // 4번 예제
        Person p1 = new Person("길동");
        p1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        p1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person p2 = new Person("철수");
        p2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

        Person p3 = new Person("영희");
        p3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook pb = new PhoneBook();
        pb.addPerson(p1);
        pb.addPerson(p2);
        pb.addPerson(p3);

        System.out.println(pb);
        System.out.println("-----");

        pb.addPerson(p3);
        System.out.println(pb);
    }

    // 1. 전화번호 나타내기
    private static class PhoneNumber {
        public final String phoneNumber;
        public PhoneNumber(String rawPhoneNum) {
            this.phoneNumber = rawPhoneNum.replaceAll("[^0-9]", "");
        }

        public String toString() {
            return "PhoneNumber{" + "phoneNumber = " + phoneNumber + '\'' + '}';
        }

        public boolean equals(Object o) {
            // PhoneNumber 객체가 아니라면 false 리턴
            if (!(o instanceof PhoneNumber)) return false;
            return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
        }
    }

    // 2. 전화번호부 사람 나타내기
    private static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;
//        private final List<String> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        // 전화번호 추가 메서드
        public void addPhoneNumber(PhoneNumber number) {
            numbers.add(number);
        }

        // 전화번호 형식 검사 (위의 변수에서 List<PhoneNumber>가 아닌 List<String>인 경우
//        public boolean addPhoneNumber(String number) {
//            for (char c : number.toCharArray()) {
//                if (!Character.isDigit(c)) return false;
//            }
//            numbers.add(number);
//            return true;
//        }

        // 3. 사람과 전화번호 비교하기
        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }

        public String toString() {
            return "Person{" + "name=" + name + '\'' + ", numbers: " + numbers + "}";
        }
    }

    // 4. 전화번호부 나타내기
//    private static class PhoneBook {
//        private final List<Person> people;
//        private PhoneBook() {
//            this.people = new ArrayList<>();
//        }
//
//        public void addPerson(Person person) {
//            people.add(person);
//        }
//
//        public String toString() {
//            return "PhoneBook{" + "people= " + people + "}";
//        }
//    }

    // 4(2). 전화번호부 나타내기 - 중복 방지
    // 4. 전화번호부 나타내기
    private static class PhoneBook {
        private final Set<Person> people;
        private PhoneBook() {
            this.people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }

        public String toString() {
            return "PhoneBook{" + "people= " + people + "}";
        }

        // 5. 전화번호를 가진 Person 객체 반환
        public Person search(PhoneNumber num) {
            // stream()을 사용하여 Set<Person>을 Stream<Person>으로 변환.
            // filter()를 사용하여 number를 가지는 Person 객체들을 찾는다.
            // 이는 다음과 같은 for 문과 동일한 역할을 수행한다.
//            for (Person p : people) {
//                if (p.hasPhoneNumber(number)) {
//                    return p;
//                }
//            }
//            return null;
            return people.stream()
                    .filter(p -> p.hasPhoneNumber(num))
                    .findFirst()
                    .orElse(null);
        }
    }
}

