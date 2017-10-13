public class Cat extends Animal implements Pet {

    private String voice;


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
