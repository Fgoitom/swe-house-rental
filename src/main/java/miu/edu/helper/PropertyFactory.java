package miu.edu.helper;

import miu.edu.model.Apartment;
import miu.edu.model.House;
import miu.edu.model.Property;

public class PropertyFactory {
    public static Property createProperty(PropertyType type){
        switch(type){
            case Apartment:
                return new Apartment();
            case House:
                return new House();

        }
        return null;
    }
}
