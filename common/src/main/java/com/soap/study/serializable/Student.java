package com.soap.study.serializable;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by ipaynow0929 on 2017/12/19.
 */
@Data
public class Student implements Externalizable {
    private static final long serialVersionUID = 5564883451376798678L;

    private String name;

    private String class_name;

    private Student(Builder builder) {
        setName(builder.name);
        setClass_name(builder.class_name);
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public static final class Builder {
        private String name;
        private String class_name;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder class_name(String val) {
            class_name = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
