public class AnimalTest {
    public static void main(String[] args) {
        Pet[] newPetArray = new Pet[2];
        Animal[] newAnimallArray = new Animal[2];
        newAnimallArray[0] = new Dog("Рррр","Баскервиль");
        Cat matroskin = new Cat("Мяу","Mатроскин");
        newAnimallArray[1] = matroskin;
        newPetArray[1]=matroskin;
        newPetArray[0]=new Dog();
        for (Animal animal:newAnimallArray) {
            animal.voice();
            System.out.println(animal.name);
        }
        for (Pet pet:newPetArray)
            pet.tenderness();
        System.out.println("Собак создано - "+Dog.dogCount);

    }

}
