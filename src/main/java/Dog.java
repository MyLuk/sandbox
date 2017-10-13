public class Dog extends Animal implements Pet {

    private String sound;

    public static int dogCount = 0; //У всех экземпляров одно значение статической переменной,
    // инициализируется только при первой загрузке класса

    public Dog (String sound, String name ) {
        super(name);
        this.sound = sound;
        dogCount++;
    }

    public Dog () {
        this("Гав", "Mухтар");
    }

    public void voice () {
        System.out.println(this.sound);
    }

    public void tenderness ( ) {
        System.out.println("Помашем хвостиком");
    }
}
