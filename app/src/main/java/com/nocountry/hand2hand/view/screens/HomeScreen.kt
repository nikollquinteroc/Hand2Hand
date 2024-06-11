package com.nocountry.hand2hand.view.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.model.CardHome
import com.nocountry.hand2hand.model.SectionHome
import com.nocountry.hand2hand.model.cards
import com.nocountry.hand2hand.model.categories
import com.nocountry.hand2hand.model.sections
import com.nocountry.hand2hand.view.components.BottomNavigationBar
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigation: NavHostController) {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    val state = rememberScrollState()

    Scaffold(
        topBar = {
            Header()
        },
        bottomBar = {
            BottomNavigationBar{
                navigation.navigate(it)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .width(420.dp)
                    .height(1629.dp)
                    .background(Color(0xFFEDEDED)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .width(380.dp)
                        .height(60.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 8.dp)
                        )

                ) {
                    SearchBar(
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = { active = false },
                        active = false,
                        onActiveChange = { active = it },
                        placeholder = {

                            Text(
                                text = "Busca un producto",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .fillMaxSize(),
                                color = Color(0xFF7C7986)
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 2.dp,
                                color = Color(0xFF967DFA),
                                shape = RoundedCornerShape(size = 8.dp)
                            ),
                        colors = SearchBarDefaults.colors(Color(0xFFFFFFFF)),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                modifier = Modifier
                                    .padding(vertical = 12.dp, horizontal = 8.dp)
                                    .size(24.dp),
                                tint = Color(0xFF6F50E9)
                            )
                        },
                        trailingIcon = {
                            if (active) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Mic,
                                        contentDescription = "Mic Icon",
                                        modifier = Modifier
                                            .padding(1.dp)
                                            .width(24.dp)
                                            .height(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Icon(
                                        modifier = Modifier
                                            .padding(vertical = 12.dp, horizontal = 8.dp)
                                            .size(24.dp)
                                            .clickable {
                                                if (text.isNotEmpty()) {
                                                    text = ""
                                                } else {
                                                    active = false
                                                }
                                            },
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close Icon"
                                    )
                                }
                            }
                        }
                    ) {}
                }
                Spacer(modifier = Modifier.height(20.dp))
                CategoriesSection()
                SaleComponent()
                Spacer(modifier = Modifier.height(10.dp))
                Body(sections = sections)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .width(284.dp)
                    .height(24.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(5.dp)
                        ,
                    painter = painterResource(R.drawable.ic_logo_hand2hand),
                    contentDescription = "")



            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF6F50E9)
        ),
        actions = {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .padding(
                        start = 4.dp,
                        top = 4.dp,
                        end = 4.dp,
                        bottom = 4.dp
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleComponent() {

    val imageList = listOf(
        R.drawable.sale_01,
        R.drawable.sale_02,
        R.drawable.sale_03,
        R.drawable.sale_04
    )

    var currentIndex by rememberSaveable { mutableIntStateOf(0) }

    val fadeInOutAnim = rememberInfiniteTransition()
    val alpha by fadeInOutAnim.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % imageList.size
        }
    }

    Card(
        onClick = { /*TODO*/ }, modifier = Modifier
            .padding(15.dp)
            .width(380.dp)
            .height(200.dp)
            .graphicsLayer(alpha = alpha)
    ) {
        Image(
            painter = painterResource(id = imageList[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }


}

@Composable
private fun CategoriesSection() {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Categorias",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .width(328.dp)
                    .height(20.dp)
                    .padding(start = 10.dp)

            )
            Text(
                text = "Ver más",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .height(16.dp)
                    .padding(end = 10.dp)
            )
        }
        LazyRow(
            Modifier
                .width(400.dp)
                .height(108.dp)
                .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            items(categories) { category ->
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .height(92.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .shadow(
                                elevation = 6.dp,
                                spotColor = Color(0x1A000000),
                                ambientColor = Color(0x1A000000)
                            )
                            .width(56.dp)
                            .height(56.dp)
                            .background(
                                color = Color(0xFF23675E),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .padding(start = 12.dp, top = 12.dp, end = 12.dp),

                        ) {
                        Image(
                            painter = painterResource(id = category.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(1.dp)
                                .width(32.dp)
                                .height(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = category.name,
                        modifier = Modifier
                            .width(70.dp)
                            .height(32.dp),
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 2,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Visible
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Composable
private fun Body(
    sections: List<SectionHome>,
) {
    LazyColumn {
        item {
            CardSection(
                textSection = sections[0].name,
                cards = cards.subList(fromIndex = 0, toIndex = 10),
                isAuction = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            CardSection(
                textSection = sections[1].name,
                cards = cards.subList(fromIndex = 3, toIndex = 10),
                isAuction = false
            )
            Spacer(modifier = Modifier.height(10.dp))
            CardSection(
                textSection = sections[2].name,
                cards = cards.subList(fromIndex = 6, toIndex = 10),
                isAuction = false
            )
            Spacer(modifier = Modifier.height(10.dp))
            CardSection(
                textSection = sections[3].name,
                cards = cards.subList(fromIndex = 8, toIndex = 10),
                isAuction = false
            )
        }
    }


}

@Composable
fun CardSection(
    textSection: String,
    cards: List<CardHome>,
    isAuction: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(420.dp)
            .height(263.dp)
    ) {
        Row(
            modifier = Modifier
                .width(380.dp)
                .height(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = textSection,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .height(16.dp)
                    .padding(start = 5.dp)

            )
            Text(
                text = "Ver más",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .height(16.dp)
                    .padding(end = 5.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .width(420.dp)
                .height(231.dp)
                .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            items(cards) { card ->
                CardItem(
                    image = card.image,
                    nameProduct = card.name,
                    price = card.price,
                    realPrice = card.realPrice,
                    description = card.description,
                    isAuction = isAuction
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    image: Int,
    nameProduct: String,
    price: String,
    realPrice: String,
    description: String,
    isAuction: Boolean
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(140.dp)
            .height(215.dp),
        onClick = { /*TODO*/ }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(140.dp)
                        .height(116.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 6.dp)
                        )

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .width(140.dp)
                    .height(99.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 0.dp))
                    .padding(start = 10.dp, top = 8.dp, end = 10.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {

                if (!isAuction) {
                    Text(
                        text = nameProduct,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF131221),
                        modifier = Modifier
                            .width(120.dp)
                            .height(16.dp)
                    )
                    Text(
                        text = price,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .width(60.dp)
                            .height(14.dp)
                    )
                    Text(
                        text = realPrice,
                        style = MaterialTheme.typography.bodySmall,
                        textDecoration = TextDecoration.LineThrough,
                        color = Color(0xFF6F50E9),
                        modifier = Modifier
                            .width(120.dp)
                            .height(16.dp)
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                            .width(120.dp)
                            .height(16.dp)
                    )
                } else {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .width(140.dp)
                            .height(99.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 0.dp)
                            )
                            .padding(start = 10.dp, top = 8.dp, end = 10.dp, bottom = 8.dp)
                    ) {
                        Text(
                            text = nameProduct,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF131221),
                            modifier = Modifier
                                .width(120.dp)
                                .height(16.dp)
                        )
                        Row {
                            Text(
                                text = "Puja actual",
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier
                                    .height(14.dp)
                                    .weight(1f),
                                color = Color(0xFF82BA84)
                            )
                            Text(
                                text = "$20.600",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF82BA84),
                                modifier = Modifier
                                    .height(16.dp)
                                    .weight(1f)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .width(120.dp)
                                .height(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                            verticalAlignment = Alignment.Top,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = null,
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .padding(1.dp)
                                    .width(12.dp)
                                    .height(12.dp)
                            )
                            Text(
                                text = "Finaliza en",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFFE82020)
                            )
                        }
                        /*Image(
                            painter = painterResource(id = R.drawable.time),
                            contentDescription = null,
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFE82020),
                                    shape = RoundedCornerShape(size = 4.dp)
                                )
                                .width(120.dp)
                                .height(17.dp)
                                .padding(start = 5.dp, top = 4.dp, end = 5.dp, bottom = 4.dp)
                        )*/
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        //CardSection("Ofertas del día")
        HomeScreen(rememberNavController())
    }
}

//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.nocountry.hand2hand.R
//import com.nocountry.hand2hand.view.components.BottomNavigationBar
//import com.nocountry.hand2hand.view.components.PerfilButton
//import com.nocountry.hand2hand.view.components.TopBar
//import com.nocountry.hand2hand.view.components.UserCard
//
//@Composable
//fun HomeScreen(navigation: NavHostController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = Color.White),
//
//        ) {
//        TopBar(" "){}
//        Divider()
//        Spacer(modifier = Modifier.height(15.dp))
//        Box(modifier = Modifier
//            .padding(15.dp)
//            .border(
//                width = 0.dp,
//                color = Color(0xFF31628d)
//            )
//        ){
//            UserCard()
//        }
//        Spacer(modifier = Modifier.height(15.dp))
//        LazyColumn(modifier = Modifier
//            .weight(1f)
//            .padding(10.dp)
//        ) {
//            item {
//
//                Column (modifier = Modifier
//                ){
//                    Text(text = "Home")
//                }
//            }
//
//
//        }
//        BottomNavigationBar {
//            navigation.navigate(it)
//        }
//    }
//}

