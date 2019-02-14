<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="javascript:;"><span>账本</span></a>
		<ul>
			<li name="accountbookinfo"><a href="/accountbookinfo_list"><span>账本信息</span></a></li>
			<li name=""><a href="#"><span>其他</span></a></li>
		</ul>
	</li>
</ul>
<script>
    $(function () {
        $("#menu [name=${currentMenu}]").addClass("active");
    })
</script>