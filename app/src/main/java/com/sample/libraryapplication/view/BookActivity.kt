package com.sample.libraryapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sample.libraryapplication.R
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.databinding.ActivityBookBinding
import com.sample.libraryapplication.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity() {

    companion object {
        private val TAG = BookActivity::class.java.simpleName
    }

    private lateinit var bookViewModel: BookViewModel
    private var isUpdateBook: Boolean = false
    private var selectedBook: BookEntity? = null
    private var selectedCategoryId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        getIntentExtras()

        createViewModel()

        setBinding()

        observeViewModel()
    }

    private fun getIntentExtras() {
        if(intent?.extras != null && intent?.extras!!.containsKey("is_update_book"))
            isUpdateBook = intent.getBooleanExtra("is_update_book", false)
        selectedBook = intent?.getParcelableExtra("selected_book") as? BookEntity
        selectedCategoryId = intent?.getLongExtra("selected_category_id", -1)
    }

    private fun createViewModel() {
        bookViewModel = ViewModelProviders.of(this)[BookViewModel::class.java]
        bookViewModel.selectedCategoryId = selectedCategoryId
        bookViewModel.selectedBook = selectedBook
        bookViewModel.isUpdateBook = isUpdateBook
        bookViewModel.bookName = selectedBook?.bookName
        selectedBook?.bookUnitPrice?.let {
            bookViewModel.bookPrice = it.toString()
        }
    }

    private fun setBinding() {
        val binding = ActivityBookBinding.inflate(layoutInflater)
        binding.viewModel = bookViewModel
        binding.book = selectedBook
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }

    private fun observeViewModel() {
        bookViewModel.isBookNameEmpty.observe(this, Observer {
            if (!isDestroyed) {
                if (it) et_name.error = getString(R.string.warning_book_name)
            }
        })

        bookViewModel.isBookPriceEmpty.observe(this, Observer {
            if (!isDestroyed) {
                if (it) et_price.error = getString(R.string.warning_book_price)
            }
        })

        bookViewModel.shouldFinishActivity.observe(this, Observer {
            if (!isDestroyed) {
                if (it) finish()
            }
        })
    }
}
