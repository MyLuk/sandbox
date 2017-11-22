package chap17;

public class fprint {
    public static void main(String[] args) throws Exception {
        fprint one = new fprint();
        one.go();

    }

    public void go() {
        String male = "man";
        User user = new User(male);
        System.out.printf("%s получает %s через лет.", user.name, "150000");
    }

    public class User {
        String name;
        public User(String name) {
            this.name = name;
        }
    }
}
