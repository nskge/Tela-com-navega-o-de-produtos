package br.unisanta.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bottomNav: BottomNavigationView

    private val iconE = android.R.drawable.ic_menu_manage
    private val iconR = android.R.drawable.ic_menu_gallery
    private val iconL = android.R.drawable.ic_menu_agenda

    private val allProducts = listOf(
        Product("Smartphone Samsung", 1999.99, R.drawable.download,    "eletronicos"),
        Product("Notebook Dell",      3499.90, R.drawable.download1,   "eletronicos"),
        Product("Fone Bluetooth",      299.00, R.drawable.download2,   "eletronicos"),
        Product("Tablet iPad",        2799.00, R.drawable.download3,   "eletronicos"),
        Product("Camiseta Básica",     49.90,  R.drawable.download4,   "roupas"),
        Product("Calça Jeans",        129.90,  R.drawable.download5,   "roupas"),
        Product("Tênis Esportivo",    249.90,  R.drawable.download6,   "roupas"),
        Product("Jaqueta de Couro",   399.90,  R.drawable.download7,   "roupas"),
        Product("Clean Code",          79.90,  R.drawable.download8,   "livros"),
        Product("O Hobbit",            39.90,  R.drawable.download9,   "livros"),
        Product("Algoritmos",         119.90,  R.drawable.download10,  "livros"),
        Product("Design Patterns",     99.90,  R.drawable.download11,  "livros")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        bottomNav    = findViewById(R.id.bottomNavigation)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        showCategory("eletronicos")

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_eletronicos -> showCategory("eletronicos")
                R.id.nav_roupas      -> showCategory("roupas")
                R.id.nav_livros      -> showCategory("livros")
            }
            true
        }
    }

    private fun showCategory(category: String) {
        val filtered = allProducts.filter { it.category == category }
        recyclerView.adapter = ProductAdapter(filtered)
    }
}