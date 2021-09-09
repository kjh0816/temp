let SelectPortrait__submitDone = false;

function SelectPortrait__submit(form) {
    if (form.portraitId.value.length == 0) {
        swal({
            title: "영정액자를 선택해주세요.",
            icon: "info",
            button: "확인",
        });

        return;
    }

    const post$ = rxjs.ajax.ajax.post(
        '/usr/director/doSelectPortrait',
        new FormData(form)
    );
    post$.subscribe(
        res => {
            if ( res.response.success ) {
                   if ( !confirm(res.response.msg) ) return false;
                   window.location.href="/usr/director/progress";
            }
            else {
                   alert(res.response.msg);
            }
        }
    );
}