package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok hl = new HelloLombok();
        hl.setAge(13);
        hl.setName("hi");

        String name = hl.getName();
        System.out.println(name);
        System.out.println(hl);
    }
}
