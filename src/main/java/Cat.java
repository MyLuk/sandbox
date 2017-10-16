import java.io.Serializable;

public class Cat extends Animal implements Pet, Serializable {

//    Не сохранять переменную при сериализации
    transient private String voice;


    public Cat(String voice, String name) {
        super(name);
        this.voice = voice;
    }

    public void voice() {
        System.out.println(this.voice);
    }

    public void tenderness () {
        System.out.println("Мур мур");
    }

}
