import java.io.Serializable;

public abstract class Animal implements Serializable {
    public String name;

    public Animal (String name) {
        this.name = name;
    }

    public Animal() {
        this.name = "Animal"; // Если этот класс не реализуетс интерфейс сериализации, то будет запущен этот конструктор при дессериализации объектов
    }

    public abstract void voice();
}
