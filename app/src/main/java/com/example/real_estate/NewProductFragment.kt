package com.example.real_estate

import android.icu.text.CaseMap
import android.os.Bundle
import android.util.EventLogTags
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [NewProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private  lateinit var Title: EditText
    private  lateinit var Sale: EditText
    private  lateinit var Price: EditText
    private  lateinit var Area: EditText
    private  lateinit var Photo: EditText
    private  lateinit var Region: EditText
    private  lateinit var ZipCode: EditText
    private  lateinit var Roof: EditText
    private  lateinit var Bedrooms: EditText
    private  lateinit var Description: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_new_product, container, false)

        Title = view.findViewById(R.id.idTitle)
        Sale = view.findViewById(R.id.idSale)
        Price = view.findViewById(R.id.idPrice)
        Area = view.findViewById(R.id.idArea)
        Photo = view.findViewById(R.id.idProto)
        Region = view.findViewById(R.id.idRegion)
        ZipCode = view.findViewById(R.id.idZipCode)
        Roof = view.findViewById(R.id.idRoof)
        Bedrooms = view.findViewById(R.id.idBedrooms)
        Description = view.findViewById(R.id.idDescription)

        view.findViewById<Button>(R.id.btn_Upload).setOnClickListener {

            var title = Title.text.toString().trim()
            var sale = Sale.text.toString().trim()
            var price = Price.text.toString().trim().toInt()
            var area =  Area.text.toString().trim().toInt()
            var photo = Photo.text.toString().trim()
            var region = Region.text.toString().trim()
            var zipCode = ZipCode.text.toString().trim().toInt()
            var roof = Roof.text.toString().trim().toInt()
            var bedrooms = Bedrooms.text.toString().trim().toInt()
            var description = Description.text.toString().trim()
            uploadData (title,sale,price,area,photo,region,zipCode,roof,bedrooms,description)
        }

        view.findViewById<Button>(R.id.btn_cansel).setOnClickListener(){
            findNavController().popBackStack(R.id.secondFragment, false)
        }


        return  view
    }


    private fun uploadData( Title: String, Sale: String, Price: Int, Area: Int, Photo: String, Region: String, ZipCode: Int, Roof: Int, Bedrooms: Int, Description: String) {


        RetrofitClient.instance.uploadProduct(Title, Sale, Price, Area, Photo, Region, ZipCode, Roof, Bedrooms,Description)
            .enqueue(object : Callback<UploadResponse> {
                override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                    Toast.makeText(context, "response.body()?.message", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<UploadResponse>, response: Response<UploadResponse>) {
                    Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()

                }
            })
    }

}