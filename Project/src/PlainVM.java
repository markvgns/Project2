public class PlainVM extends VM {
  private int PlainSSD;

  public PlainVM(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    super(VmId, VMCPU, VMRAM, VMSoftware);

    this.PlainSSD = PlainSSD;

  }

  public int getPlainSSD() {
    return PlainSSD;
  }

  public void setPlainSSD(int plainSSD) {
    PlainSSD = plainSSD;
  }
}
