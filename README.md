# ItemFactoryPlus

Questo plugin ti permetterà di creare item super mega iper fighissimi uau

Oltre a personalizzarli, sarai in grado di settare delle azioni quando l'item viene cliccato e quando c'è una interazione.

Esempio:

```
ItemStack itemStack = new FactoryItem(Material.ACACIA_FENCE)
                .setName("&bTest item")
                .setLore(Arrays.asList("&7This is a test item", "&7with lore!"))
                .addEnchant(Enchantment.ARROW_DAMAGE, 1)
                .setActionWhenClick(event -> {
                    event.getWhoClicked().sendMessage("You clicked the item " + event.getCurrentItem().getItemMeta().getDisplayName() + "!");
                })
                .setActionWhenInteract(event -> {
                    event.getPlayer().sendMessage("You have interacted the item " + event.getItem().getItemMeta().getDisplayName() + "!");
                })
                .registerClickListener(this)
                .registerInteractListener(this)
                .build();
```

Andiamo a creare un nuovo oggetto ItemStack, che come valore avrà una nuova istanza di FactoryItem, passandogli come valore il material:

```
.setName() per settare il nome
.setLore() per settare i lore (richiede una lista)
.addEnchant() aggiunge un enchant
.setActionWhenClick() aggiunge una o più azioni quando l'item viene cliccato su un inventario (richiede il registerClickListener(JavaPlugin))
.setActionWhenInteract() aggiunge una o più azioni quando l'item viene interactato (richiede il registerInteractListener(JavaPlugin))
.build() ritorna l'ItemStack
```

Gradle:
```
implementation 'com.github.Lory9098:ItemFactoryPlus:Tag'
```

Maven:
```
<groupId>com.github.Lory9098</groupId>
<artifactId>ItemFactoryPlus</artifactId>
<version>Tag</version>
```



Ci sono molte altre funzioni, se non le capisci, hai bisogno di aiuto o vuoi dare dei consigli, contattami su discord: smodev_
