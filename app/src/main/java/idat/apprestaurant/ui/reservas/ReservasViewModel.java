package idat.apprestaurant.ui.reservas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReservasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReservasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui Iran Las Reservas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}