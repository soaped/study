package com.soap.study.serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author ipaynow0929
 * @date 2017/12/19
 */
@Data
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 2266537254878411764L;

    transient private String name;

    private Integer age;

    private Person(Builder builder) {
        setName(builder.name);
        setAge(builder.age);
    }

    public static final class Builder {
        private String name;
        private Integer age;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

            public Person build() {
            return new Person(this);
        }
    }
}
