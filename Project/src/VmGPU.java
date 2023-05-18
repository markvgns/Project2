public class VmGPU extends PlainVM {
  int VMGPU;

  public VmGPU(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VMGPU) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD);

    this.VMGPU = VMGPU;

  }
}
