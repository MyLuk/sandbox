package chap15;

public class TestThreads {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
        one.start();
        two.start();
    }
}




    class Accum {
        public static Accum a = new Accum();
        private int conuter = 0;

        private Accum() {
        }

        ;

        public static Accum getAccum() {
            return a;
        }

        public void updateConuter(int add) {
            conuter += add;
        }

        public int getConuter() {
            return conuter;
        }
    }
    class ThreadOne implements Runnable {
            Accum a = Accum.getAccum();

        @Override
        public void run() {
            for (int x=0; x<98; x++) {
                a.updateConuter(1000);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {}
            }
            System.out.println("one " + a.getConuter());
        }
    }
    class ThreadTwo implements Runnable {
        Accum a = Accum.getAccum();

        @Override
        public void run() {
            for (int x=0; x<99; x++) {
                a.updateConuter(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {}
            }
            System.out.println("two " + a.getConuter());
        }
}