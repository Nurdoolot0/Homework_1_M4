package com.example.homework_1_m4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_1_m4.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments
        if (arguments != null && arguments.containsKey("userData")) {

            val args = SecondFragmentArgs.fromBundle(arguments)
            val userData = args.userData
            binding.nameTextView.text = "Имя: ${userData.name}"
            binding.emailTextView.text = "Электронная почта: ${userData.email}"
            binding.passwordTextView.text = "Пароль: ${userData.password}"
        } else {

            binding.nameTextView.text = "вы ничего не передали"
            binding.emailTextView.text = ""
            binding.passwordTextView.text = ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
