import java.util.UUID;

public class LogicalVolume extends LVMSYSTEM{

    int size;
    public LogicalVolume(String name,int size,  VolumeGroup volumeGroup){
        super(name, UUID.randomUUID());
        this.size = size;

    }

    public int getSize(){
        return size;
    }

}
