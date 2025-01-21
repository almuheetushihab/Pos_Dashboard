package com.example.posdashboard.ui.components

import java.lang.reflect.Modifier

@Composable
fun InvoiceScreen(
    invoiceNo: String,
    invoiceDate: String,
    customerName: String,
    customerPhone: String,
    cashierName: String,
    terminalId: String,
    productList: List<Product>,
    subTotal: Double,
    discount: Double,
    vat: Double,
    total: Double,
    paymentMethod: String,
    footerNote: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Text(
            text = "BARNOi Lifestyle",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Building # 235 (Beside of High School Playground), Taherpur Municipality, Taherpur, Bagmara, Rajshahi 6251",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Phone: 01924547474",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider()

        // Invoice Info
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Invoice No: $invoiceNo", style = MaterialTheme.typography.body1)
                Text(text = "Invoice Date: $invoiceDate", style = MaterialTheme.typography.body1)
            }
            Column {
                Text(text = "Terminal ID: $terminalId", style = MaterialTheme.typography.body1)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Customer Name: $customerName", style = MaterialTheme.typography.body1)
                Text(text = "Phone: $customerPhone", style = MaterialTheme.typography.body1)
            }
            Column {
                Text(text = "Cashier: $cashierName", style = MaterialTheme.typography.body1)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()

        // Product Table Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "SL", style = MaterialTheme.typography.body1)
            Text(text = "Product Name", style = MaterialTheme.typography.body1)
            Text(text = "Unit Price", style = MaterialTheme.typography.body1)
            Text(text = "QTY", style = MaterialTheme.typography.body1)
            Text(text = "Unit Total", style = MaterialTheme.typography.body1)
        }
        Divider()

        // Product List
        productList.forEachIndexed { index, product ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${index + 1}", style = MaterialTheme.typography.body2)
                Text(text = product.name, style = MaterialTheme.typography.body2)
                Text(text = "${product.unitPrice}", style = MaterialTheme.typography.body2)
                Text(text = "${product.quantity}", style = MaterialTheme.typography.body2)
                Text(text = "${product.unitPrice * product.quantity}", style = MaterialTheme.typography.body2)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()

        // Summary
        Column(modifier = Modifier.align(Alignment.End)) {
            Text(text = "Sub Total: $subTotal", style = MaterialTheme.typography.body1)
            Text(text = "Discount: $discount", style = MaterialTheme.typography.body1)
            Text(text = "VAT: $vat", style = MaterialTheme.typography.body1)
            Divider()
            Text(text = "Total Payable: $total", style = MaterialTheme.typography.h6)
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Footer
        Divider()
        Text(text = "Payment Method: $paymentMethod", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = footerNote, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Thanks for being with us",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        BarcodeSection()
        Text(
            text = "Powered by Softzino Technologies\nhttps://softzino.com",
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BarcodeSection() {
    // Placeholder for barcode
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Black)
    )
}

data class Product(val name: String, val unitPrice: Double, val quantity: Int)
