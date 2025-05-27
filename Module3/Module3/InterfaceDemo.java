interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("🎸 Strumming the guitar...");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("🎹 Pressing the piano keys...");
    }
}

class Drums implements Playable {
    @Override
    public void play() {
        System.out.println("🥁 Beating the drums...");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Playable[] instruments = { new Guitar(), new Piano(), new Drums() };

        for (Playable instrument : instruments) {
            perform(instrument);
        }
    }

    private static void perform(Playable instrument) {
        System.out.print("Now performing: ");
        instrument.play();
    }
}
