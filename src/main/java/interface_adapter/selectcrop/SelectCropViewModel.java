package main.java.interface_adapter.selectcrop;

import main.java.interface_adapter.ViewModel;

public class SelectCropViewModel extends ViewModel {

    public SelectCropViewModel() {
        super("selectCropView");
        setState(new SelectCropState());
    }
}
