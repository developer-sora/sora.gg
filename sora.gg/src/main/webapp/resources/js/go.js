function goDel(t) {
	let ok = confirm("삭제 합니까?");
	if (ok) {
		location.href = "delTip?c_no=" + t;
	}
}
