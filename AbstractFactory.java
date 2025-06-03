interface Toy {
    String play();
}

interface ToyFactory {
    Toy makeForKids();
    Toy makeForChild();
    Toy makeToy();
}

 class Doll implements Toy {
    @Override
    public String play() {
        return "Play doll";
    }
    
}

 class Car implements Toy {
    @Override
    public String play() {
        return "Play car";
    }
}

 class LittleCarToy extends Car {

    @Override
    public String play(){
        System.out.println("Play little car");
        return "";
    }
}

class MiddleCarToy extends Car {
    @Override
    public String play(){
        System.out.println("Play middle car");
        return "";
    }
}



class LittleDollToy extends Doll{
    @Override
    public String play(){
        System.out.println("Play little doll");
        return "";
    }

}

class MiddleDollToy extends Doll {

    @Override
    public String play(){
        System.out.println("Play middle doll");
        return "";
    }

}

abstract class AbstractToyFactory {

    public static Toy makeToy(ToyFactory factory, String type) {
        if(type.toLowerCase().equals("child")){
            return factory.makeForChild();
        }
        if(type.toLowerCase().equals("kids")){
            return factory.makeForKids();
        }
        return factory.makeToy();
    }
}

class DollFactory implements ToyFactory {

    @Override
    public Toy makeForKids() {
        return new LittleDollToy();
    }

    @Override
    public Toy makeForChild() {
        return new MiddleDollToy();
    }

    @Override
    public Toy makeToy() {
        return new Doll();
    }

}

class CarFactory implements ToyFactory {

    @Override
    public Toy makeForKids() {
        return new LittleCarToy();
    }

    @Override
    public Toy makeForChild() {
        return new MiddleCarToy();
    }
    @Override
    public Toy makeToy(){
        return new Car();
    }
    
}

class Main {
    public static void main(String[] args) {
        Toy myToy = AbstractToyFactory.makeToy(new CarFactory(), "child");
        myToy.play();
    }
}