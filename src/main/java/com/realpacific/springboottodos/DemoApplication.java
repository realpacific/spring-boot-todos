package com.realpacific.springboottodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    private void doSome(){
        Number[] nums = new Number[5];
        nums[0] = new Integer(1); // Ok
        nums[1] = new Double(2.0); // Ok
        Integer[] intArr = new Integer[5];

        Number[] numArr = intArr; // Ok
        numArr[0] = 1.23; // Not ok
        numArr[0] = 1;

        ArrayList<Integer> intArrList = new ArrayList<>();
        ArrayList<? super Integer> numArrList = intArrList; // Not ok
        ArrayList<Integer> anotherIntArrList = intArrList; // Ok

        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<? super Integer> nums2 = new ArrayList<>();

        ints.add(new Integer(1)); // Ok
        nums2.add(new Integer(2)); // Ok
        Object n = nums2.get(0); // Not ok
    }

}
