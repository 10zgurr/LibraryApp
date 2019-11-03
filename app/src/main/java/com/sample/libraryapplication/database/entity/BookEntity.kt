package com.sample.libraryapplication.database.entity

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.sample.libraryapplication.view.BookActivity
import java.util.*

@Entity(tableName = "books",
    foreignKeys = [ForeignKey(entity = CategoryEntity::class, parentColumns = ["category_id"], childColumns = ["book_category_id"], onDelete = CASCADE)])
class BookEntity() : Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    var bookID: Long? = null
    @ColumnInfo(name = "book_name")
    var bookName: String? = null
    @ColumnInfo(name = "book_unit_price")
    var bookUnitPrice: Double? = null
    @ColumnInfo(name = "book_category_id")
    var bookCategoryID: Long? = null

    constructor(bookID: Long?, bookName: String?, bookUnitPrice: Double?, bookCategoryID: Long?) : this() {
        this.bookID = bookID
        this.bookName = bookName
        this.bookUnitPrice = bookUnitPrice
        this.bookCategoryID = bookCategoryID
    }

    constructor(parcel: Parcel) : this() {
        bookID = parcel.readValue(Long::class.java.classLoader) as? Long
        bookName = parcel.readString()
        bookUnitPrice = parcel.readValue(Double::class.java.classLoader) as? Double
        bookCategoryID = parcel.readValue(Long::class.java.classLoader) as? Long
    }

    // for DiffUtil class
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BookEntity) return false
        val book = other as? BookEntity
        return bookID == book?.bookID
                && bookName == book?.bookName
                && bookUnitPrice == book?.bookUnitPrice
                && bookCategoryID == book?.bookCategoryID
    }

    override fun hashCode(): Int {
        return Objects.hash(bookID, bookName, bookUnitPrice, bookCategoryID)
    }

    // databinding onClick
    fun onBookItemClicked(view: View, book: BookEntity) {
        val intent = Intent(view.context, BookActivity::class.java)
        intent.putExtra("selected_category_id", book.bookCategoryID)
        intent.putExtra("selected_book", book)
        intent.putExtra("is_update_book", true)
        view.context.startActivity(intent)
    }

    // parcelable stuff
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(bookID)
        parcel.writeString(bookName)
        parcel.writeValue(bookUnitPrice)
        parcel.writeValue(bookCategoryID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookEntity> {
        override fun createFromParcel(parcel: Parcel): BookEntity {
            return BookEntity(parcel)
        }

        override fun newArray(size: Int): Array<BookEntity?> {
            return arrayOfNulls(size)
        }
    }
}