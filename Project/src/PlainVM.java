public class PlainVM extends VM {
  int PlainSSD;

  public PlainVM(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    super(VmId, VMCPU, VMRAM, VMSoftware);

    this.PlainSSD = PlainSSD;

  }
}
