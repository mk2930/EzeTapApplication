package com.example.ezetapapplicaton.display_ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ezetapapplicaton.R
import com.example.ezetapapplicaton.base.BaseActivity
import com.example.ezetapapplicaton.data.model.FetchCustomeDataResponse
import com.example.ezetapapplicaton.databinding.ActivityDisplayBinding
import com.example.ezetapapplicaton.utils.CommonUtils
import com.squareup.picasso.Picasso


class DisplayActivity : BaseActivity() {

    companion object {
        fun launch(activity: Context, bundle: Bundle) {
            var intent = Intent(activity, DisplayActivity::class.java)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }


    lateinit var binding: ActivityDisplayBinding
    lateinit var vm: DisplayViewModel
    var data: FetchCustomeDataResponse? = null

    override fun initViewModel() {
        vm =
            ViewModelProvider(this).get(DisplayViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display)
        binding.lifecycleOwner = this
        binding.vm = vm
        context = this
        setViewModel(vm)


    }

    override fun observeLivedata() {

    }

    private fun getIntentdata() {
        val data =
            intent.getParcelableExtra<FetchCustomeDataResponse>(CommonUtils.PASS_FETCH_UI_DATA) as FetchCustomeDataResponse

        setView(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getIntentdata()


    }

    @SuppressLint("ResourceAsColor")
    private fun setView(data: FetchCustomeDataResponse) {
        Picasso.get().load(data.logourl).into(binding.ivLogo)
        binding.tvHeader.text = data.headingText

        if (data.uidata != null && data.uidata?.size!! > 0) {
            for (ui in data.uidata!!) {
                var lparams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )

                lparams.setMargins(0, 8, 0, 8)

                when (ui.uitype) {


                    "label" -> {
                        val tv = TextView(context)
                        tv.layoutParams = lparams
                        tv.text = ui.value
                        binding.layoutUi.addView(tv)
                    }
                    "edittext" -> {
                        val et = EditText(context)
                        et.layoutParams = lparams
                        et.hint = ui.hint
                        binding.layoutUi.addView(et)

                    }
                    "button" -> {
                        val bt = Button(context)
                        bt.layoutParams = lparams
                        bt.hint = ui.hint
                        bt.text = ui.value
                        binding.layoutUi.addView(bt)
                    }

                }


            }

        }

    }
}