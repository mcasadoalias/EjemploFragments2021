package es.iesnervion.ejemplofragments2021;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

enum ScreenSize
{
    SMALL, BIG, UNKNOWN;
}
public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> clickedBtn = new MutableLiveData<Integer>();
    private ScreenSize screenSize = ScreenSize.UNKNOWN;
    private MutableLiveData<String> detailText = new MutableLiveData<String>();

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public MutableLiveData<Integer> getClickedBtn() {
        return clickedBtn;
    }

    public void setClickedBtn(MutableLiveData<Integer> clickedBtn) {
        this.clickedBtn = clickedBtn;
    }

    public void setClickedBtn(int id) {
        this.clickedBtn.setValue(id);
    }

    public MutableLiveData<String> getDetailText() {
        return detailText;
    }

    public String getDetailTextValue() {
        return detailText.getValue();
    }

    public void setDetailText(MutableLiveData<String> detailText) {
        this.detailText = detailText;
    }

    public void setDetailText(String text) {
        this.detailText.setValue(text);
    }

}
