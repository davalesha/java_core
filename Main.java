package java_core.block1.task2_2_persons;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 20; i++) {  /*10_000_000;*/
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        print(persons);

//       1. Для поиска несовершеннолетних используйте промежуточный метод filter() и терминальный метод count().
//        (т.е. людей младше 18 лет).
        Stream<Person> stream = persons.stream();
        long count = stream.filter(person -> person.getAge() < 18).count();
        System.out.println(count);

//       2. Для получения списка призывников потребуется применить несколько промежуточных методов filter(),
//          а также для преобразования данных из Person в String (так как нужны только фамилии) используйте метод map().
//          Так как требуется получить список List<String> терминальным методом будет collect(Collectors.toList()).
//        Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        Stream<Person> stream2 = persons.stream();
        List<String> personList = stream2
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

        for (String pr : personList) {
            System.out.println(pr);
        }

//      3. Для получения отсортированного по фамилии списка потенциально работоспособных людей с высшим образованием
//         необходимо применить ряд промежуточных методов filter(), метод sorted() в который нужно будет положить компаратор
//         по фамилиям Comparator.comparing(). Завершить стрим необходимо методом collect().
//        (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).

        Stream<Person> stream3 = persons.stream();
        List<Person> personListsort =
                stream3.filter(person -> person.getEducation().equals(Education.HIGHER))
                        .filter(person -> ((person.getSex().equals(Sex.MAN) && (person.getAge() >= 18 && person.getAge() <= 65)) ||
                                (person.getSex().equals(Sex.WOMEN) && (person.getAge()) >= 18 && person.getAge() <= 60)))
                        .sorted(Comparator.comparing(person -> person.getFamily()))
                        .collect(Collectors.toList());

        print(personListsort);
    }


    private static void print(Collection<Person> persons) {
        for (Person pr : persons) {
            System.out.println(pr);
        }
    }
}
