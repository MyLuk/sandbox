import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeAndDeserialize {

    public static void main(String[] args) {
        Cat Vasia = new Cat("уррр", "Васька");
        Dog mucha = new Dog("аввв", "Мухтар");
//        Serialize
        try {
            FileOutputStream fileStream = new FileOutputStream("MyAnimal.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(Vasia);
            os.writeObject(mucha);
            os.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
//        Deserialize
        try {
            FileInputStream fileInputStream = new FileInputStream("MyAnimal.ser");
            ObjectInputStream is = new ObjectInputStream(fileInputStream);
            Cat vasia2 = (Cat) is.readObject(); //По умолчанию возвращает тип Object
            Dog mucha2 = (Dog) is.readObject();
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
