package com.example.sobes.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean)-> Unit,
    isError: Boolean = false,
    checkBoxColors: CheckboxColors = CheckboxColors(
        checkedBoxColor = MaterialTheme.colorScheme.primary,
        uncheckedBoxColor = MaterialTheme.colorScheme.background,
        checkedCheckmarkColor = MaterialTheme.colorScheme.background,
        uncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        uncheckedCheckmarkColor = MaterialTheme.colorScheme.secondaryContainer,
        checkedBorderColor = MaterialTheme.colorScheme.primary,
        disabledBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledIndeterminateBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledCheckedBoxColor = MaterialTheme.colorScheme.background,
        disabledUncheckedBoxColor = MaterialTheme.colorScheme.background,
        disabledUncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledIndeterminateBoxColor = MaterialTheme.colorScheme.secondaryContainer,
    ),
    checkBoxErrorColors: CheckboxColors = CheckboxColors(
        checkedBoxColor = MaterialTheme.colorScheme.background,
        uncheckedBoxColor = MaterialTheme.colorScheme.background,
        checkedCheckmarkColor = MaterialTheme.colorScheme.secondaryContainer,
        uncheckedBorderColor = MaterialTheme.colorScheme.onTertiary,
        uncheckedCheckmarkColor = MaterialTheme.colorScheme.onTertiary,
        checkedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledIndeterminateBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledCheckedBoxColor = MaterialTheme.colorScheme.background,
        disabledUncheckedBoxColor = MaterialTheme.colorScheme.background,
        disabledUncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledIndeterminateBoxColor = MaterialTheme.colorScheme.secondaryContainer,
    )
){
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = if(isError) checkBoxErrorColors else checkBoxColors,
       // modifier = Modifier.height(25.dp).width(20.dp)
    )
}