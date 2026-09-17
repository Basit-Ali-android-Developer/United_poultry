package com.example.unitedpoultry.AdminDashBoard.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unitedpoultry.AdminSettingModule.AdminRateHistoryActivity
import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.unitedpoultry.R
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

import com.example.unitedpoultry.databinding.FragmentReportsAdminBinding


class ReportsAdminFragment : Fragment() {

    private lateinit var binding: FragmentReportsAdminBinding
   // private lateinit var shopAdapter: ShopVisitedAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportsAdminBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardRateHistory.setOnClickListener {
            val intent = Intent(requireContext(), AdminRateHistoryActivity::class.java)
            startActivity(intent)
        }

        binding.cardInventory.setOnClickListener {
            showDateSelectionDialog(requireContext())
        }

        binding.cardShop.setOnClickListener {
            showDateSelectionDialog(requireContext())
        }

                binding.cardSaleReport.setOnClickListener {
                    showDateSelectionDialog(requireContext())
        }

//        binding.cardAreaReport.setOnClickListener {
//            val intent = Intent(requireContext(), AdminAreaReportActivity::class.java)
//            startActivity(intent)
//        }


//        binding.cardDiscountReport.setOnClickListener {
//            val intent = Intent(requireContext(), AdminDiscountReportActivity::class.java)
//            startActivity(intent)
//        }



//        val  = listOf(
//            ShopvisitedModel("Jalal Sons", "Last visit: 3 days ago. Rs. 12500. 12 orders", R.drawable.visitedshopimage1),
//            ShopvisitedModel("Al-Fatah Store", "Last visit: 5 days ago. Cash collection", R.drawable.visitedshopimage2),
//            ShopvisitedModel("Green Valley Mart", "Last visit: 2 days ago. Cash collection", R.drawable.visitedshopimage1),
//            ShopvisitedModel("Mini Mart Central", "Last visit: 1 day ago. 9 Boxes. Credit", R.drawable.visitedshopimage2)
//        )
//
//        shopAdapter = ShopVisitedAdapter(historyList.toMutableList())
//        binding.rvVisitedShops.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvVisitedShops.adapter = shopAdapter

//        val assignedShops = 40
//        val visitedShops = 30
//        val remainingShops = 10
//
//        binding.tvAssignedShops.text = "$assignedShops%"
//        binding.pAssignedshops.progress = assignedShops
//
//        binding.tVisitedShops.text = "$visitedShops%"
//        binding.pVisitedShops.progress = visitedShops
//
//        binding.tvRemainingShops.text = "$remainingShops%"
//        binding.pRemainingShops.progress = remainingShops


    }


    fun showDateSelectionDialog(
        context: Context,
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_report, null)

        val btnFromDate = dialogView.findViewById<MaterialButton>(R.id.btnFromDate)
        val btnToDate = dialogView.findViewById<MaterialButton>(R.id.btnToDate)
        val btnCancel = dialogView.findViewById<MaterialButton>(R.id.btnCancel)
        val btnShow = dialogView.findViewById<MaterialButton>(R.id.btnShow)
        var fromDate = ""
        var toDate = ""

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Setup DatePicker for From Date
        btnFromDate.setOnClickListener {
            DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    fromDate = dateFormat.format(calendar.time)
                    btnFromDate.text = "From: $fromDate"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Setup DatePicker for To Date
        btnToDate.setOnClickListener {
            DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    toDate = dateFormat.format(calendar.time)
                    btnToDate.text = "To: $toDate"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        // Dismiss dialog on Cancel click
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnShow.setOnClickListener {
            if (fromDate.isEmpty() || toDate.isEmpty()) {
                Toast.makeText(context, "Please select both From and To dates", Toast.LENGTH_SHORT).show()
            } else {
            //    onDateRangeSelected(fromDate, toDate)
                dialog.dismiss()
            }
        }

        dialog.show()
    }
}
