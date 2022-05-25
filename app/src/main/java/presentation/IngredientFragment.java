package presentation;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.recipeapp.R;

import objects.Ingredient;

public class IngredientFragment extends DialogFragment {

    private ReturnIngredientInterface returnIngredientInterface;
    private EditText iName;
    private EditText iAmount;
    private EditText iUnits;
    private EditText iNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.fragment_add_ingredient, null);
        iName = (EditText) dialogView.findViewById(R.id.name);
        iAmount = (EditText) dialogView.findViewById(R.id.amount);
        iUnits = (EditText) dialogView.findViewById(R.id.units);
        iNote = (EditText) dialogView.findViewById(R.id.note);

        builder.setView(dialogView)
                .setTitle("Add Ingredient")
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        IngredientFragment.this.getDialog().cancel();
                    }
                })
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        final AlertDialog d = (AlertDialog)getDialog();
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.fragment_add_ingredient, null);

        if(d != null)
        {
            Button positiveButton = (Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Boolean wantToCloseDialog = false;

                    TextView i = (TextView) dialogView.findViewById(R.id.ingredientNameText);

                    String name = iName.getText().toString();
                    String amount = iAmount.getText().toString();
                    String units =iUnits.getText().toString();
                    String notes = null;
                    if(!TextUtils.isEmpty(iNote.getText().toString())) {
                        notes = iNote.getText().toString();
                    }
                    System.out.println(name + " ");

                    if(TextUtils.isEmpty(iName.getText().toString()))
                    {
                        Toast.makeText(getActivity(), "Please fill in a name", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(iAmount.getText().toString()))
                    {
                        Toast.makeText(getActivity(), "Please fill in an amount", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        Ingredient newIng = new Ingredient(name, amount, units, notes);
                        returnIngredientInterface.onSelectedData(newIng);
                        wantToCloseDialog = true;
                    }

                    if(wantToCloseDialog)
                        d.dismiss();
                    //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
                }
            });
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            returnIngredientInterface = (ReturnIngredientInterface) activity;
        }
        catch (ClassCastException e) {
            Log.d("MyDialog", "Activity doesn't implement the ReturnDataInterface interface");
        }
    }

}