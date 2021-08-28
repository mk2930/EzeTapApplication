package com.example.ezetapapplicaton.fetch_custome_ui

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ezetapapplicaton.R
import com.example.ezetapapplicaton.base.BaseActivity
import com.example.ezetapapplicaton.databinding.ActivityFetchCutomeUiBinding
import com.example.ezetapapplicaton.display_ui.DisplayActivity
import com.example.ezetapapplicaton.utils.CommonUtils

class FetchCutomeUiActivity : BaseActivity() {
    private lateinit var binding: ActivityFetchCutomeUiBinding
    private lateinit var vm: FetchCustomeUiViewModel

    override fun initViewModel() {
        vm =
            ViewModelProvider(this).get(FetchCustomeUiViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fetch_cutome_ui)
        //setContentView(_binding.root)
        binding.lifecycleOwner = this
        binding.vm = vm
        context = this
        setViewModel(vm)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


    }

    override fun observeLivedata() {
        vm.openDisplayActivity.observe(this, Observer { openActivity ->
            if (openActivity) {
                var bundle = Bundle()
                bundle.putParcelable(CommonUtils.PASS_FETCH_UI_DATA, vm.data)
                DisplayActivity.launch(context, bundle)

            }
        })

        vm.showProgressBar.observe(this, Observer { isLoading ->
            if (isLoading) {
                binding.progressbar.visibility = View.VISIBLE

            } else {
                binding.progressbar.visibility = View.GONE
            }


        })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (CommonUtils.isInternetAvailable(this))
            vm.fetchCustomeUi()
        else
            showToast(context.getString(R.string.no_internet))


    }


}