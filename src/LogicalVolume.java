import java.util.UUID;

public class LogicalVolume extends LVMSYSTEM{

    private int size;
    private VolumeGroup volumeGroup;
    public LogicalVolume(String name,int size,  VolumeGroup volumeGroup){
        super(name, UUID.randomUUID());
        this.size = size;
        this.volumeGroup = volumeGroup;

    }

    public int getSize(){
        return size;
    }

    public VolumeGroup getVolumeGroup(){
        return  volumeGroup;
    }

}
