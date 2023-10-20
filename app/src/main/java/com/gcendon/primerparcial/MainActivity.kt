package com.gcendon.primerparcial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRecetas: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecetas = findViewById(R.id.rv_recetas)
        rvRecetas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvRecetas.adapter = adapter
        adapter.submitList(getListadoRecetas())

        adapter.onItemClickListener = {
            navegarDetalle(it)
        }
    }

    private fun navegarDetalle(receta: Receta) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }

    private fun getListadoRecetas(): MutableList<Receta>? {
        return mutableListOf(
            Receta(
                1,
                "Chocotorta",
                Pais.ARGENTINA,
                "facil",
                "https://cdn0.recetasgratis.net/es/posts/8/9/6/chocotorta_helada_76698_600_square.jpg",
                "• 600 gramos de galletitas de chocolate\n" +
                        "• 600 gramos de queso crema\n" +
                        "• 400 gramos de dulce de leche\n" +
                        "• 1 vaso de leche\n" +
                        "• 1 cucharada sopera de cacao dulce",
                "La chocotorta es un postre originario de Argentina. Con el lanzamiento en 1975 por Bagley, de una variedad de galletitas de chocolate, marca Chocolinas, en muchas poblaciones del sur de Santa Fe se comenzó a elaborar en los hogares este postre, conocido como «el postre de las chocolinas»."

            ),
            Receta(
                2,
                "Milanesa Napolitana",
                Pais.ARGENTINA,
                "media",
                "https://www.paulinacocina.net/wp-content/uploads/2015/03/P1150541-e1439164269502.jpg",
                "• 150g de queso mozzarella\n" +
                        "• 150g de jamón cocido\n" +
                        "• Una lata de puré de tomate\n" +
                        "• Una cebolla\n" +
                        "• 2 dientes de Ajo\n" +
                        "• 2 hojas de Laurel fresco\n" +
                        "• Aceite\n" +
                        "• Sal",
                "La milanesa a la napolitana es un plato típico de la gastronomía rioplatense propia de Argentina que tiene su origen en la influencia de la inmigración italiana."
            ),
            Receta(
                3,
                "Fugazetta Rellena",
                Pais.ARGENTINA,
                "media",
                "https://img-global.cpcdn.com/recipes/6bc24e2204fc621f/1200x630cq70/photo.jpg",
                "• 600 g harina 0000\n" +
                        "• 30 g levadura fresca\n" +
                        "• 1/2 cda. sal\n" +
                        "• 3 cdas. aceite\n" +
                        "• 1cdta. azúcar\n" +
                        "• 1 y 1/2 taza agua tibia\n" +
                        "• 2 cebollas\n" +
                        "• 150 g mozzarella\n" +
                        "• 100 g queso fresco\n" +
                        "• orégano y aceite\n" +
                        "• optativo jamón cocido",
                "Se trata de una pizza rellena de mozzarella. Sobre la masa se pone la mozzarella, se cubre con una segunda capa de masa como si fuese una empanada y, sobre ésta segunda capa, se coloca la cebolla y un poco de parmesano."
            ),
            Receta(
                4,
                "Ají de gallina",
                Pais.PERU,
                "facil",
                "https://www.recetas-argentinas.com/base/stock/Recipe/61-image/61-image_web.jpg.webp",
                "• 1 gallina de 2 kilos aprox.\n" +
                        "• 1/2 taza de aceite\n" +
                        "• 1/4 de kilo de cebolla picada\n" +
                        "• 1/2 cucharada de ajos molidos\n" +
                        "• 6 ajíes verdes licuados\n" +
                        "• 1 lata de leche evaporada\n" +
                        "• 4 rodajas de pan molido\n" +
                        "• 1/4 de kilo de nueces\n" +
                        "• 10 cucharadas de queso parmesano rallado\n" +
                        "• Papas amarillas cocidas\n" +
                        "• sal\n" +
                        "• pimienta al gusto ",
                "El ají de gallina es un plato típico de la gastronomía peruana, concretamente de la costa, que consiste en un ají o crema espesa con pechuga de gallina deshilachada. Esta crema es servida con papas cocidas, y en ocasiones con arroz blanco."
            ),
            Receta(
                5,
                "Causa limeña",
                Pais.PERU,
                "dificil",
                "https://www.pequerecetas.com/wp-content/uploads/2019/07/causa-limena-receta.jpg",
                "• 3 ajíes amarillos\n" +
                        "• 1 kilogramo de papas amarillas\n" +
                        "• 3 limones\n" +
                        "• 60 mililitros de aceite vegetal\n" +
                        "• Sal y pimienta al gusto\n" +
                        "• Para el relleno:\n" +
                        "• 250 gramos de pollo\n" +
                        "• 2 cebollas\n" +
                        "• 1 pimentón verde\n" +
                        "• 5 ajíes\n" +
                        "• 100 gramos de mayonesa\n" +
                        "• 1 aguacate mediano picado en rebanadas\n" +
                        "• 1 zanahoria mediana ",
                "La causa a la limeña, causa limeña o simplemente causa, es un entrante típico y muy extendido de la gastronomía del Perú que tiene origen precolombino."
            ),
            Receta(
                6,
                "Chivito uruguayo",
                Pais.URUGUAY,
                "facil",
                "https://www.clarin.com/img/2021/08/09/4gmSk0qMg_1200x630__1.jpg",
                "• 2 tomates\n" +
                        "• Sal, al gusto\n" +
                        "• 4 hojas de lechuga\n" +
                        "• 4 panes de hamburguesa\n" +
                        "• Mayonesa, al gusto\n" +
                        "• 4 cortes de carne delgados de Top Sirloin (milanesa)\n" +
                        "• 1 cucharada de aceite\n" +
                        "• 4 huevos\n" +
                        "• 4 rebanadas gruesas de queso mozarella\n" +
                        "• 4 rebanadas de jamón",
                "El chivito es un sándwich de carne vacuna y otros ingredientes, generalmente aderezado con mayonesa y acompañado de papas fritas, algunas veces con ensalada rusa u otra guarnición. Se inventó en Punta del Este, Uruguay."
            ),
            Receta(
                7,
                "Feijoada",
                Pais.BRASIL,
                "facil",
                "https://www.comedera.com/wp-content/uploads/2022/03/feijoada-brasilena-500x500.jpg",
                "• Frijoles negros remojados 12 horas 500 g\n" +
                        "• Chorizo criollo 125 g\n" +
                        "• Lomo de cerdo 125 g\n" +
                        "• Panceta 100 g\n" +
                        "• Costilla de cerdo 150 g\n" +
                        "• Diente de ajo picado 1\n" +
                        "• Cebolla picada 0.5\n" +
                        "• Pimiento rojo picado 0.5\n" +
                        "• Pimiento verde picado 0.5\n" +
                        "• Tomate 0.5\n" +
                        "• Laurel 1\n" +
                        "• Pimienta negra molida\n" +
                        "• Sal\n" +
                        "• Aceite de oliva virgen extra",
                "La feijoada es uno de los platos típicos de la cocina brasileña, original de la gastronomía de Portugal que lo popularizó también en Mozambique y Angola. Sus ingredientes básicos son los frijoles y la carne de cerdo en salazón. Se suele presentar acompañada de arroz y naranjas."
            )
        )
    }
}