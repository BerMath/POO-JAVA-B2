public class RemiseStandard extends Remise {
    public RemiseStandard() {
        super(0); // 0% de remise pour client standard
    }

    @Override
    public String getTypeClient() {
        return "Standard";
    }
}