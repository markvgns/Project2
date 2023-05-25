public class PlainVM extends VM {
  private int PlainSSD;

  private int Allocated_SSD;

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

  public int getAllocated_SSD() {
    return Allocated_SSD;
  }

  public void setAllocated_SSD(int allocated_SSD) {
    Allocated_SSD = allocated_SSD;
  }
}
