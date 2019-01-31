package com.maseko.root.stickyheaderlibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {

    public static final int VIEW_TYPE_GROUP = 0;
    public static final int VIEW_TYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;

    public static List<String> alphabet_available = new ArrayList<>();

    public static ArrayList<Person> sortList(ArrayList<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });

        return people;
    }

    public static ArrayList<Person> addAlphabets(ArrayList<Person> list) {

        int i = 0;

        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEW_TYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0)));

        customList.add(firstPosition);

        for (i = 0; i < list.size()-1; i++) {
            Person person = new Person();
            char name1 = list.get(i).getName().charAt(0);
            char name2 = list.get(i+1).getName().charAt(0);

            if (name1 == name2) {
                list.get(i).setViewType(VIEW_TYPE_PERSON);
                customList.add(list.get(i));
            } else {
                list.get(i).setViewType(VIEW_TYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEW_TYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);
            }
        }

        list.get(i).setViewType(VIEW_TYPE_PERSON);
        customList.add(list.get(i));

        return customList;

    }

    public static int findPositionWithName(String name, ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> getAlphabet() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            char character = (char) i;
            result.add(String.valueOf(character));

        }

        return result;
    }

    public static ArrayList<Person> getPeopleGroup() {
        ArrayList<Person> personList = new ArrayList<>();

        Person person = new Person("Maseko", "Director", -1);
        personList.add(person);

        person = new Person("DekEko", "Director", -1);
        personList.add(person);
        person = new Person("Ambon", "Director", -1);
        personList.add(person);
        person = new Person("Apip", "Director", -1);
        personList.add(person);
        person = new Person("Rojak", "Director", -1);
        personList.add(person);
        person = new Person("Tejo", "Director", -1);
        personList.add(person);
        person = new Person("Pujo", "Director", -1);
        personList.add(person);
        person = new Person("Sela", "Director", -1);
        personList.add(person);

        return personList;


    }
}
