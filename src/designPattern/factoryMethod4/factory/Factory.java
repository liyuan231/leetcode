package designPattern.factoryMethod4.factory;

public class Factory {
    public static AbstractFactory retrieveAbstractFactory(String language) {
        switch (language) {
            case "malay": {
                return new MalayFactory();
            }
            case "indonesian": {
                return new IndonesianFactory();
            }
            default:
                throw new IllegalArgumentException(language);
        }

    }
}
