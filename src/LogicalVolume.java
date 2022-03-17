import java.util.UUID;

public class LogicalVolume extends SUPERCLASS{

    int size;
    public LogicalVolume(String name,int size,  String volumeGroup){
        super(name, UUID.randomUUID());
        this.size = size;

    }

}
