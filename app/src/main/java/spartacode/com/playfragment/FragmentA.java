package spartacode.com.playfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    CommunicateFrag communicateFrag;

    public interface  CommunicateFrag
    {
        public void sendData(String data);
    }

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicateFrag = (CommunicateFrag)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        communicateFrag.sendData("Data from Fragment A");
        return inflater.inflate(R.layout.fragment_, container, false);
    }

}
