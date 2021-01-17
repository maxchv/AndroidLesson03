package org.itstep.customlist;

import java.util.Arrays;
import java.util.List;

public class StudentData {
    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Вася", R.drawable.sample1, "ВПУ811"),
                new Student("Маша", R.drawable.sample2, "СПД911"),
                new Student("Рома", R.drawable.sample3, "ВПУ811"),
                new Student("Миша", R.drawable.sample4, "ВПУ811"),
                new Student("Даша", R.drawable.sample5, "ВПУ811")
        );
    }
}
