package com.example.appui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.TransactionType
import com.example.CircularImageView
import com.example.CvIconButton
import com.example.CvImageView
import com.example.CvTextView
import com.example.XifiPayView
import com.example.appui.model.Transaction
import com.example.appui.ui.theme.AppUITheme
import com.example.appui.ui.theme.brightOrange
import com.example.appui.ui.theme.dividerColor
import com.example.appui.ui.theme.liteGreen
import com.example.appui.ui.theme.liteTxtColor
import com.example.appui.ui.theme.starBgColor
import com.example.appui.ui.theme.subTxtColor
import com.example.appui.ui.theme.txtGreen
import com.example.appui.ui.theme.txtNameColor
import com.example.appui.ui.theme.txtOrange
import com.example.appui.ui.theme.txtViewAll
import com.example.appui.ui.theme.vpaIdColor
import com.productSansMedium
import com.productSansRegular
import com.robotoRegular
import com.sdp
import com.setAmountColor
import com.setTransactionMessage
import com.setTranscationType
import com.sfProDisplayBold
import com.sfProDisplayRegular
import com.ssp

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollState = rememberScrollState()

            AppUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Transparent,
                                scrolledContainerColor = Color.Blue
                            ),
                            title = {},
                            navigationIcon = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ) {
                                    CvIconButton(
                                        R.drawable.ic_back,
                                        modifier = Modifier.scale(1.2f),
                                        iconDescription = "Back"
                                    ) { }
                                    CvIconButton(
                                        R.drawable.ic_setting, modifier = Modifier.scale(1.2f),
                                        iconDescription = "Setting"
                                    ) { }
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        IconButton(
                            content = {
                                Image(
                                    painter = painterResource(R.drawable.ic_scan_qr),
                                    stringResource(R.string.cd_scan_qr)
                                )
                            },
                            onClick = {
                            },
                            modifier = Modifier
                                .scale(1.8f)
                                .padding(bottom = 12.sdp, end = 12.sdp)
                        )
                    }
                ) { innerPadding ->
                    MainScreenUI(scrollState)
                }
            }
        }
    }

    @Composable
    fun MainScreenUI(scrollState: androidx.compose.foundation.ScrollState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            Column(modifier = Modifier.fillMaxHeight(0.5f)) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painter = painterResource(id = R.drawable.ic_bg),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(top = 120.sdp)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)

                        ) {
                            Box(
                                contentAlignment = Alignment.BottomEnd, // Aligns the QR code at the bottom-right
                                modifier = Modifier
                            ) {
                                CircularImageView(
                                    imgRes = R.drawable.ic_profile_pic,
                                    modifier = Modifier.size(50.sdp)
                                )
                                Box(
                                    modifier = Modifier
                                        .size(24.sdp) // Size of the QR code container
                                        .clip(CircleShape),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    CircularImageView(
                                        imgRes = R.drawable.ic_scanner,
                                        modifier = Modifier
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(16.sdp))

                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(3.sdp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                CvTextView(
                                    txt = stringResource(R.string.txt_name_surname),
                                    fontSize = 19.ssp,
                                    textColor = txtNameColor,
                                    style = sfProDisplayBold,
                                    modifier = Modifier
                                )
                                Row {
                                    CvTextView(
                                        txt = stringResource(R.string.txt_vpa_id),
                                        style = robotoRegular,
                                        fontSize = 13.ssp,
                                        textColor = txtNameColor
                                    )
                                    CvTextView(
                                        txt = stringResource(R.string.txt_cryptouser_ixfi),
                                        style = robotoRegular,
                                        fontSize = 13.ssp,
                                        textColor = vpaIdColor
                                    )
                                    Image(
                                        painter = painterResource(R.drawable.ic_copy),
                                        contentDescription = stringResource(R.string.cd_copy),
                                        Modifier
                                            .padding(start = 8.sdp)
                                            .size(14.sdp)
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.padding(top = 36.sdp))

                        //Pay to Contact
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.sdp)
                        ) {

                            CurvedCard()

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(top = 4.sdp)
                            ) {
                                val text by remember { mutableStateOf("") }
                                var textFieldValue by remember { mutableStateOf("") } // State to hold text input

                                OutlinedTextField(
                                    value = textFieldValue,
                                    onValueChange = { newText -> textFieldValue = newText }, // Update state on text input
                                    placeholder = {
                                        CvTextView(
                                            txt = stringResource(R.string.txt_pay_to_contact),
                                            textColor = Color.Gray,
                                            fontSize = 14.ssp
                                        )
                                    },
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(R.drawable.ic_search), // Replace with your drawable resource
                                            contentDescription = stringResource(R.string.cd_search_icon)
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(2.5f),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        errorContainerColor = Color.Transparent,
                                        cursorColor = Color.Black,
                                        selectionColors = LocalTextSelectionColors.current,
                                        focusedBorderColor = Color.Transparent, // Set transparent since we're using a custom border
                                        unfocusedBorderColor = Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(8.sdp) // Rounded corners
                                )

                                Image(
                                    painter = painterResource(R.drawable.ic_scan_to_pay),
                                    stringResource(R.string.cd_scan_to_pay),
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 10.sdp)
                                    .scale(1.1f),
                                )
                            }
                        }

                        //Unlock Payment
                        Box(modifier = Modifier.fillMaxSize()) {
                            // Background Image
                            Image(
                                painter = painterResource(id = R.drawable.banner_unlock), // Replace with your image resource
                                contentDescription = stringResource(R.string.cd_background_image),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        top = 14.sdp,
                                        start = 18.sdp,
                                        end = 18.sdp,
                                        bottom = 14.sdp
                                    ),
                            )

                            // Overlay content
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 48.sdp, top = 30.sdp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                // Main Title
                                CvTextView(
                                    txt = stringResource(R.string.txt_unlock),
                                    fontSize = 30.ssp,
                                    style = sfProDisplayBold,
                                    textColor = Color.White,
                                )

                                Spacer(modifier = Modifier.height(4.sdp))

                                // Subtext with icons
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    CvTextView(
                                        txt = stringResource(R.string.txt_send),
                                        fontSize = 14.ssp,
                                        fontWeight = FontWeight.Bold,
                                        textColor = txtOrange
                                    )
                                    Spacer(modifier = Modifier.width(4.sdp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_arrow_send), // Replace with your send icon resource
                                        contentDescription = stringResource(R.string.cd_send),
                                        modifier = Modifier.size(14.sdp)
                                    )
                                    CvTextView(
                                        txt = stringResource(R.string.comma),
                                        fontSize = 14.ssp,
                                        fontWeight = FontWeight.Bold,
                                        textColor = Color.White,
                                        modifier = Modifier.padding(horizontal = 2.sdp)
                                    )

                                    CvTextView(
                                        txt = stringResource(R.string.txt_receive),
                                        fontSize = 14.ssp,
                                        fontWeight = FontWeight.Bold,
                                        textColor = txtGreen
                                    )
                                    Spacer(modifier = Modifier.width(2.sdp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_arrow_receive), // Replace with your receive icon resource
                                        contentDescription = stringResource(R.string.cd_receive),
                                        modifier = Modifier.size(14.sdp)
                                    )
                                }

                                // Footer Text
                                CvTextView(
                                    txt = stringResource(R.string.txt_payments),
                                    fontSize = 26.ssp,
                                    style = sfProDisplayBold,
                                    fontWeight = FontWeight.SemiBold,
                                    textColor = Color.White,
                                    modifier = Modifier.padding(top = 4.sdp),
                                )
                            }
                        }
                    }
                }
            }

            //Xifi pay
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.sdp),
                horizontalArrangement = Arrangement.Center
            ) {
                XifiPayView(modifier = Modifier, isVisible = true)

                Box(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(start = 3.sdp, bottom = 2.sdp)
                ) {
                    CvTextView(
                        txt = "to",
                        style = sfProDisplayRegular,
                        fontSize = 22.ssp,
                        textColor = txtNameColor
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_down_arrow),
                    "Down Arrow",
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .padding(start = 3.sdp, top = 12.sdp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.sdp, start = 16.sdp, end = 16.sdp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_contact,
                        stringResource(R.string.vd_contact),
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        stringResource(R.string.txt_contacts),
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_vpa,
                        stringResource(R.string.cd_vpa),
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        stringResource(R.string.txt_vpa),
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_receive,
                        stringResource(R.string.cd_receive),
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        stringResource(R.string.txt_receive),
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 28.sdp))

            //USDC Free Transfer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.sdp)
                    .offset(x = 18.sdp)
                    .background(
                        color = starBgColor,
                        shape = RoundedCornerShape(
                            topStart = 100.sdp,
                            bottomStart = 100.sdp
                        )
                    )
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_percent_star_bg),
                        stringResource(R.string.bg_img),
                        modifier = Modifier
                            .offset(x = (-10).sdp, y = (-2).sdp)
                            .scale(1.1f)
                    )
                    // Content above the image
                    Column(
                        modifier = Modifier
                            .padding(top = 16.sdp, bottom = 16.sdp, end = 18.sdp)
                    ) {
                        // Text Content
                        Row(verticalAlignment = Alignment.Bottom) {
                            CvTextView(
                                txt = stringResource(R.string.wave_hand),
                                fontSize = 21.ssp,
                                fontWeight = FontWeight.Bold,
                                style = sfProDisplayBold
                            )
                            CvTextView(
                                txt = stringResource(R.string.txt_usdc_free_transfer),
                                fontSize = 18.ssp,
                                fontWeight = FontWeight.Bold,
                                style = sfProDisplayBold
                            )
                        }

                        Spacer(modifier = Modifier.height(8.sdp))
                        CvTextView(
                            txt = stringResource(R.string.txt_transfer_desc),
                            fontSize = 15.ssp,
                            style = robotoRegular,
                            textColor = subTxtColor,
                            modifier = Modifier.padding(start = 10.sdp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(34.sdp))

            //Your Contacts
            ProfileTitleWithXifiPay(stringResource(R.string.txt_your_contact_on))

            Spacer(modifier = Modifier.size(3.sdp))

            //Profile for Xifi Pay
            XifiPayHorizontalProfileList(
                listOf(
                    Pair(R.drawable.ic_user_1, stringResource(R.string.leesa_monork)),
                    Pair(R.drawable.ic_user_2, stringResource(R.string.smith_smith)),
                    Pair(R.drawable.ic_user_3, stringResource(R.string.miller_davis)),
                    Pair(R.drawable.ic_user_4, stringResource(R.string.manica_jho))
                )
            )

            //Invite your Friend
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.sdp)
                    .paint(painter = painterResource(R.drawable.ic_invite_frnd_bg)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1.7f)
                        .padding(horizontal = 22.sdp)
                ) {
                    CvTextView(
                        txt = "Invite Your friends",
                        style = sfProDisplayBold,
                        fontSize = 19.ssp
                    )
                    Spacer(modifier = Modifier.height(4.sdp))
                    CvTextView(
                        txt = "Invite your friends to Earn IXFI points ",
                        style = robotoRegular,
                        fontSize = 15.ssp,
                        textColor = liteTxtColor
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_invite_frnd),
                    stringResource(R.string.cd_invite_your_friend),
                    modifier = Modifier
                        .weight(1f)
                        .scale(1.1f)
                        .padding(bottom = 10.sdp),
                    contentScale = ContentScale.Fit
                )
            }

            ProfileTitleWithXifiPay(stringResource(R.string.txt_buy_more_with))
            Spacer(modifier = Modifier.size(3.sdp))

            //Profile for Xifi Pay
            XifiPayHorizontalProfileList(
                listOf(
                    Pair(R.drawable.ic_brand_1, stringResource(R.string.puma)),
                    Pair(R.drawable.ic_brand_2, stringResource(R.string.starbucks)),
                    Pair(R.drawable.ic_brand_3, stringResource(R.string.ferrari)),
                    Pair(R.drawable.ic_brand_4, stringResource(R.string.dominoz))
                )
            )

            Spacer(modifier = Modifier.size(12.sdp))

            //Recent Transactions
            ProfileTitleWithXifiPay(
                title = stringResource(R.string.txt_recent_transactions),
                showXifiPay = false
            )
            TransactionListUI()

            Image(
                painter = painterResource(R.drawable.ic_design_with_love_care),
                stringResource(R.string.cd_bottom_hader),
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.sdp)
                    .navigationBarsPadding()
            )
        }
    }

    @Composable
    fun TransactionListUI() {
        val transactions = listOf(
            Transaction(
                name = stringResource(R.string.martine_d),
                amount = 500,
                date = stringResource(R.string.martine_d_28_05_23_10_11_12),
                transactionType = TransactionType.DEBIT,
                profilePic = null
            ),
            Transaction(
                name = stringResource(R.string.leesa_m),
                amount = 2800,
                date = stringResource(R.string.leesa_m_30_05_23_10_11_12),
                transactionType = TransactionType.CREDIT,
                profilePic = R.drawable.ic_user_1
            ),
            Transaction(
                name = stringResource(R.string.kareem_k),
                amount = 500,
                date = stringResource(R.string.kareem_k_28_05_23_10_11_12),
                transactionType = TransactionType.DEBIT,
                profilePic = R.drawable.ic_user_kareem
            ),
            Transaction(
                stringResource(R.string.manica_j),
                500,
                stringResource(R.string.manica_j_28_05_23_10_11_12),
                TransactionType.CREDIT,
                R.drawable.ic_user_manica
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.sdp)
        ) {
            transactions.forEachIndexed { i, transaction ->
                TransactionItem(transaction, showDivider = transactions.size - 1 != i)
            }
        }
    }

    @Composable
    fun TransactionItem(transaction: Transaction, showDivider: Boolean) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.sdp)
        ) {
            // Profile Icon
            Box(
                modifier = Modifier
                    .size(48.sdp)
                    .clip(RoundedCornerShape(12.sdp))
                    .background(color = brightOrange),
                contentAlignment = Alignment.Center
            ) {
                if (transaction.profilePic == null) {
                    CvTextView(
                        txt = transaction.name[0].toString(),
                        textColor = Color.White,
                        style = productSansMedium,
                        fontSize = 24.ssp
                    )
                } else {
                    Image(
                        painter = painterResource(id = transaction.profilePic),
                        contentDescription = null,
                        modifier = Modifier.scale(1.2f),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.sdp))

            // Details Section
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Name
                CvTextView(
                    txt = transaction.name,
                    style = productSansMedium,
                    fontSize = 15.ssp
                )

                Spacer(modifier = Modifier.height(4.sdp))

                // Sent Securely Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.sdp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.sdp)
                            .clip(CircleShape)
                            .background(liteGreen) // Green dot
                    )
                    Spacer(modifier = Modifier.width(8.sdp))
                    CvTextView(
                        txt = setTransactionMessage(transaction.transactionType),
                        textColor = subTxtColor,
                        style = robotoRegular,
                        fontSize = 14.ssp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.sdp))

            // Amount & Date
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 4.sdp)
            ) {
                // Amount
                CvTextView(
                    txt = setTranscationType(transaction.amount, transaction.transactionType),
                    textColor = setAmountColor(transaction.transactionType), // Orange color
                    style = productSansRegular,
                    fontSize = 14.ssp
                )

                Spacer(modifier = Modifier.height(4.sdp))

                // Date
                CvTextView(
                    txt = transaction.date,
                    textColor = subTxtColor,
                    style = productSansRegular,
                    fontSize = 14.ssp
                )
            }
        }

        // Divider
        Log.d("DivierLine", "$showDivider")
        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.sdp),
                thickness = 1.sdp,
                color = dividerColor
            )
        }
    }

    @Composable
    fun XifiPayHorizontalProfileList(list: List<Pair<Int, String>>) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.sdp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            list.forEach { profile ->
                ProfileCard(profileImage = profile.first, username = profile.second)
            }
        }
    }

    @Composable
    fun ProfileTitleWithXifiPay(title: String, showXifiPay: Boolean = true) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.sdp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Row {
                CvTextView(
                    txt = title,
                    style = sfProDisplayBold,
                    fontSize = 19.ssp
                )
                XifiPayView(
                    modifier = Modifier
                        .height(24.sdp)
                        .padding(horizontal = 6.sdp),
                    isVisible = showXifiPay
                )
            }

            Row(
                modifier = Modifier.padding(end = 14.sdp),
                verticalAlignment = Alignment.Bottom
            ) {
                CvTextView(
                    txt = stringResource(R.string.cd_view_all),
                    textColor = txtViewAll,
                    fontSize = 12.ssp,
                    style = productSansRegular,
                    modifier = Modifier
                )
                Icon(
                    painter = painterResource(R.drawable.ic_view_all),
                    stringResource(R.string.cd_view_all), modifier = Modifier
                        .scale(1.2f)
                        .padding(top = 2.sdp, start = 8.sdp)
                )
            }
        }
    }

    @Composable
    fun ProfileCard(profileImage: Int, username: String) {
        Column(
            modifier = Modifier
                .width(80.sdp)
                .padding(horizontal = 2.sdp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = null,
                modifier = Modifier
                    .size(65.sdp)
                    .clip(RoundedCornerShape(16.sdp))
                    .background(Color.Gray),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(4.sdp))
            CvTextView(
                txt = username,
                style = robotoRegular,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 11.ssp,
                textColor = txtNameColor
            )
        }
    }

    @Composable
    fun CurvedCard() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .paint(
                    painter = painterResource(id = R.drawable.ic_box_border)
                )
        ) {

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.sdp, start = 1.sdp, end = 1.sdp)
                    .height(55.sdp)
            ) {

                val path = Path().apply {
                    val curveHeight = 30f
                    val cornerRadius = 12.dp.toPx() // Convert dp to pixels

                    // Start at the top-left corner with a rounded corner
                    moveTo(0f, cornerRadius)
                    arcTo(
                        rect = Rect(0f, 0f, cornerRadius * 2, cornerRadius * 2),
                        startAngleDegrees = 180f,
                        sweepAngleDegrees = 90f,
                        forceMoveTo = false
                    )

                    // Top curve
                    quadraticBezierTo(
                        size.width / 2, // Control point X
                        -10f, // Control point Y (peak of curve)
                        size.width - cornerRadius, // End point X
                        0f // End point Y
                    )

                    // Top-right corner
                    arcTo(
                        rect = Rect(
                            size.width - cornerRadius * 2,
                            0f,
                            size.width,
                            cornerRadius * 2
                        ),
                        startAngleDegrees = 270f,
                        sweepAngleDegrees = 90f,
                        forceMoveTo = false
                    )

                    // Right side
                    lineTo(size.width, size.height - curveHeight - cornerRadius)

                    // Bottom-right corner
                    arcTo(
                        rect = Rect(
                            size.width - cornerRadius * 2,
                            size.height - curveHeight - cornerRadius * 2,
                            size.width,
                            size.height - curveHeight
                        ),
                        startAngleDegrees = 0f,
                        sweepAngleDegrees = 90f,
                        forceMoveTo = false
                    )

                    // Bottom curve
                    quadraticBezierTo(
                        size.width / 2, // Control point X
                        135f, // Control point Y (dip of curve)
                        cornerRadius, // End point X
                        size.height - curveHeight // End point Y
                    )

                    // Bottom-left corner
                    arcTo(
                        rect = Rect(
                            0f,
                            size.height - curveHeight - cornerRadius * 2,
                            cornerRadius * 2,
                            size.height - curveHeight
                        ),
                        startAngleDegrees = 90f,
                        sweepAngleDegrees = 90f,
                        forceMoveTo = false
                    )

                    // Left side
                    lineTo(0f, curveHeight + cornerRadius)

                    close() // Close the path
                }

                // Draw the path with a border and fill color
                drawPath(
                    path = path,
                    color = Color.White
//                    color = liteGreen
                )
                drawPath(
                    path = path,
                    color = Color.Transparent, // Border color
                    style = Stroke(width = 6f) // Border width
                )
            }
        }
    }
}
