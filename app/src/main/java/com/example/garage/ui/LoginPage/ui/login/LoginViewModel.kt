package com.example.garage.ui.LoginPage.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.garage.ui.LoginPage.ui.login.state.LoginPageClickActions
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _clickActions = MutableSharedFlow<LoginPageClickActions>()
    val clickActions = _clickActions.asSharedFlow()

    fun onCloseButtonClickListener(){
        viewModelScope.launch {
            _clickActions.emit(LoginPageClickActions.CloseButtonAction)
        }
    }

}