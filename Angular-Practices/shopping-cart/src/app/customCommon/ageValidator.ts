import { AbstractControl, ValidationErrors } from "@angular/forms";


export function MinimumAge(control: AbstractControl): ValidationErrors | null {
    const controlValue = control.value;
    if (isNaN(controlValue) || controlValue < 18) {
        return { 'minage': true, 'requiredValue': 18 };
    }

    return null;
}