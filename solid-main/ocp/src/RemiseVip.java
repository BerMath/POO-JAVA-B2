public class RemiseVip extends Remise {
    public RemiseVip() {
        super(0.2); // 20% de remise
    }

    @Override
    public String getTypeClient() {
        return "VIP";
    }
}